# System Design Case Studies

Document 4 end-to-end system designs. These are crucial for mid-level to senior roles in international companies.

## Design 1: Scalable E-commerce Order Management System

### Requirements
- Handle 10K orders/day
- Multi-region support
- Real-time order tracking
- Inventory synchronization
- Payment processing integration

### Architecture Components
- API Gateway (load-balanced)
- Order Service (Spring Boot)
- Inventory Service
- Payment Service (external)
- Notification Service
- Database (PostgreSQL)
- Cache (Redis)
- Message Queue (RabbitMQ/Kafka)

### Data Flow
1. User places order → API Gateway
2. Order Service validates and creates order
3. Inventory Service reserved stock
4. Payment Service processes payment
5. On success, Notification Service sends email
6. Message queue updates inventory asynchronously

### Scaling Strategy
- Horizontal scaling: multiple Order Service instances
- Database sharding: by order region or customer ID
- Caching layer: frequently accessed orders, inventory counts
- Read replicas for reporting queries

### Reliability & Fault Tolerance
- Circuit breaker pattern for external service calls
- Retry logic with exponential backoff
- Dead letter queue for failed messages
- Database transactions for consistency
- Idempotency keys to prevent duplicate orders

### Tradeoffs
- **Consistency vs. Availability**: Eventual consistency via message queues (sacrifices immediate inventory sync for availability)
- **Cost vs. Performance**: More caches = higher cost but better latency
- **Complexity vs. Simplicity**: Message queues add complexity but decouple services

---

## Design 2: Real-time Notification System

### Requirements
- Support 1M+ users
- Low latency (<100ms)
- Multi-channel: email, SMS, push, in-app
- Priority queue (urgent notifications first)
- User preferences and throttling

### Architecture Components
- API / Webhook receiver
- Notification Service (Java)
- Priority Queue (Kafka topics)
- Channel Workers: EmailWorker, SMSWorker, PushWorker
- Template Engine
- Database (notification history)
- Cache (user preferences, throttle counters)

### Data Flow
1. Event triggered (user action, system alert)
2. API receives notification request
3. Notification Service validates user preferences
4. Pushes to priority Kafka queue
5. Channel-specific workers consume and send
6. Log delivery status

### Scaling Strategy
- Kafka partitions by user ID → ensures ordering per user
- Multiple worker instances
- Rate limiting per user per channel
- Batch sending for non-urgent notifications

### Reliability & Fault Tolerance
- Retry logic for failed sends (email bounces, API timeouts)
- Dead letter queue for permanent failures
- Acknowledgment tracking (ensures delivery)
- Graceful degradation (if SMS fails, try email)

### Tradeoffs
- **Delivery guarantee vs. Latency**: At-most-once is faster but loses messages; at-least-once is slower
- **Storage vs. Performance**: Store all history vs. aggregate only

---

## Design 3: Distributed Cache Layer (Redis) with Microservices

### Requirements
- Cache user sessions
- Store product catalogs
- Cache frequently queried data
- Handle cache invalidation
- Support TTL and LRU eviction

### Architecture Components
- Redis cluster (master-replica setup)
- Application layer (Spring Boot services)
- Message broker (for cache invalidation events)
- Monitoring and alerting

### Data Flow
1. Service checks Redis for key
2. If hit, return data
3. If miss, fetch from database
4. Write to Redis with TTL
5. On data change, emit cache invalidation event
6. Workers listen and delete keys

### Scaling Strategy
- Redis Cluster: hash slots distributed across nodes
- Replica for read throughput
- Separate cache instances for hot data
- TTL strategy: 5 min for user data, 1 hour for catalogs

### Reliability & Fault Tolerance
- Replica failover (automatic)
- Sentinel for Redis monitoring
- Cache miss graceful handling (DB fallback)
- Circuit breaker if Redis is down

### Tradeoffs
- **Memory cost vs. Performance**: More data in cache = faster but expensive
- **Consistency vs. Availability**: Cache invalidation delay = stale data risk

---

## Design 4: Microservices Architecture with Service Mesh

### Requirements
- Decouple teams (Order, User, Payment, Inventory services)
- Service discovery
- Load balancing
- Resilience (retries, timeouts, circuit breakers)
- Observability (logs, metrics, traces)

### Architecture Components
- Multiple microservices (Spring Boot)
- Service mesh (Istio) or load balancer
- API Gateway (Kong, Envoy)
- Service discovery (Eureka, Consul)
- Message broker (Kafka for async)
- Monitoring stack (Prometheus, Grafana, Jaeger)

### Data Flow
1. Request hits API Gateway
2. Gateway routes to service
3. Service discovers dependencies
4. Service mesh handles inter-service communication
5. Observability stack tracks all calls

### Scaling Strategy
- Independent scaling per service
- Auto-scaling based on CPU/memory
- Canary deployments for safe rollouts

### Reliability & Fault Tolerance
- Service mesh provides retries, timeouts
- Circuit breaker per service pair
- Bulkhead isolation (prevent cascade failures)
- Health checks and readiness probes

### Tradeoffs
- **Complexity vs. Flexibility**: Service mesh adds ops overhead but enables resilience
- **Network latency**: Inter-service calls slower than monolith but better scaling

---

## Next Steps
1. Pick one design above and write pseudocode / architecture diagram
2. Practice explaining one design in 10 minutes (interview prep)
3. Research one real-world example (e.g., Amazon, Netflix architecture)
4. Add code sketches (Java/Spring for Order Service, REST endpoints)

## Resources
- "Designing Data-Intensive Applications" (DDIA)
- System Design Interview (Alex Xu) YouTube
- Grokking System Design Interview
