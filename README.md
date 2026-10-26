## Bài tập về nhà UET
- Lập trình hệ thống (C).
- Lập trình nâng cao (Java).

## Test mermaid
```mermaid
classDiagram

class User {
    String username
    String displayName
    String password
    boolean active
    String description
    String avatarURL
    String email
    List<Item> itemsOwned
    BigDecimal balance
}
class BidderProfile {
    List<Auction> AuctionJoined
}
class SellerProfile {
    List<Auction> AuctionStarted
}
class AdminProfile {
    List<String> actionLog
}

User *-- BidderProfile
User *-- SellerProfile
User *-- AdminProfile

class Wallet {
    BigDecimal 
}
class Item {
    <<Abstract>>
    <<FactoryMethod>>
    String itemId
    String ownerAccountName
    String name 
    String description
    String imageURL
}

class Electronics
class Art 
class Vehicle

Item <|-- Electronics
Item <|-- Art
Item <|-- Vehicle
class AuctionManager {
    <<Singleton>>
    Map<String,Auction> auctionMap
}
AuctionManager *-- Auction
class Auction {
    String auctionId
    String title
    String SellerId
    String leadingBidderId
    String itemId
    List<BidTransaction> BidHistory
    LocalDateTime startTime
    LocalDateTime endTime
    BigDecimal currentPrice
    BigDecimal smallestIncrement
    AuctionStatus auctionStatus
}
class AuctionStatus{
    <<Enum>>
    SCHEDULED
    RUNNING
    FINISHED
    PAID
    CANCELLED
}
class BidTransaction{
    String auctionId 
    String bidderId 
    BigDecimal amount
    LocalDateTime timestamp
}
Auction *-- BidTransaction
class Notification {
    <<interface>>    
}

Notification <.. User

Auction "has status"--> AuctionStatus
```
