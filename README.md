# SDP Assignment 5: Strategy Pattern

Smart Parking Garage simulation demonstrating runtime strategy switching, automated selection, and isolated external data sources.

## 1. Class Responsibilities (SRP)

| Class / Interface | Responsibility |
| :--- | :--- |
| `PricingStrategy` | Defines the contractual method for parking cost calculations. |
| `StandardPricingStrategy` | Calculates parking cost using a fixed hourly rate. |
| `DynamicSurgePricingStrategy` | Calculates parking cost based on weather and occupancy. |
| `SubscriberVIPPricingStrategy` | Calculates parking cost with free initial hours. |
| `PricingContext` | Delegates price calculation to the active pricing strategy. |
| `PricingSelector` | Chooses a pricing strategy based on environmental conditions. |
| `LegacyPricingCalculator` | Demonstrates monolithic price calculation logic before pattern refactoring. |
| `SpaceAllocationStrategy` | Defines the contractual method for parking spot selection. |
| `NearestSpaceStrategy` | Assigns parking spots nearest to the garage exit. |
| `ZoneBasedStrategy` | Assigns parking spots within designated specialized zones. |
| `RandomSpaceStrategy` | Assigns parking spots randomly across available garage spaces. |
| `SpaceAllocationContext` | Delegates spot allocation to the active allocation strategy. |
| `SpaceAllocationSelector` | Chooses an allocation strategy based on vehicle type. |
| `ExternalEnvironmentService` | Defines the contract for fetching external environmental metrics. |
| `SimulatedEnvironmentService` | Provides mock data for weather and occupancy rates. |

## 2. Pattern Comparison

* **Strategy vs. State**: Strategy was chosen because algorithms are selected externally at runtime. State was avoided because garage behaviors do not trigger internal state transitions automatically.
* **Strategy vs. Template Method**: Strategy was chosen to provide complete algorithm replacement via composition. Template Method was avoided because it relies on inheritance and fixed skeletal steps.
