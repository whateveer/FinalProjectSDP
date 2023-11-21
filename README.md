**FINAL PROJECT REPORT**

on the Software Design Patterns discipline

  

**Ali Samal**

Group: SE-2219

Teacher: Mansur Zhanbolat

  

**Introduction**

  

**Project Overview**

  

The project is a well-structured multimedia content management system that incorporates various design patterns to promote extensibility and maintainability. It is designed to facilitate the creation, storage, and consumption of different types of content, including music and podcasts. The system supports user roles such as Listeners, Singers, and Podcasters, each with distinct functionalities.

  

**Purpose and Objectives**

  

The primary purpose of the project is to demonstrate the effective implementation of design patterns in software development. Design patterns provide reusable solutions to common problems, fostering code organization, and enhancing system flexibility. The project aims to showcase the application of several design patterns, such as Observer, Strategy, Decorator, Adapter, and Singleton, to address specific challenges in the multimedia content domain.

  

**Importance of Design Patterns**

  

Design patterns play a crucial role in software development by offering proven solutions to recurring design problems. They improve code readability, promote code reuse, and simplify maintenance. In this project, design patterns are leveraged to enhance the structure and flexibility of the multimedia content management system.

  

  

  

**Main Body**

  

**UML Diagram**

  
![uml_dependencies](https://github.com/whateveer/FinalProjectSDP/assets/66480258/ceb1921d-6672-4f22-a05f-525fd508e7d9)

_UML including dependencies_


![uml2](https://github.com/whateveer/FinalProjectSDP/assets/66480258/b4bf4c9b-cf64-4f7c-8212-f6c78aaf4f74)

_UML without dependencies_


**Observer Pattern: Keeping Users Informed**

  

The Observer pattern is instrumental in the implementation of a dynamic notification system. Through the `IPaymentStatusObserver` interface, payment status changes are efficiently communicated to relevant components. For instance, the `PaymentMachine` employs this pattern to notify various payment methods (e.g., `DollarPayment` and `TengePayment`) about transaction outcomes.


<img width="653" alt="Subscriber" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/45e87962-e0b2-4f40-b57e-96e9e734b8ba">

_Screenshot 1 Subscriber_


<img width="395" alt="Subject" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/d43108c1-3993-4b9f-b2a6-0b4154355418">

_Screenshot 2 Subject_

  

**Singleton Pattern: Ensuring a Single Database Connection**

  

The Singleton pattern is pivotal in managing a single, shared database connection across the entire application. The `DatabaseConnection` class guarantees that only one instance exists, optimizing resource usage and providing a centralized point for database access. This ensures data consistency and integrity throughout the system.

  
<img width="472" alt="Singleton" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/99be37c9-58d2-4029-aead-36e182fb51be">

_Screenshot 3 Singleton_

  

**Strategy Pattern: Flexibility in User Actions**

  

The Strategy pattern facilitates a flexible approach to user actions. The `IStrategy` interface, implemented by classes like `Listener`, `Singer`, and `Writer`, allows users to dynamically select and execute different content-related actions. For example, a `Singer` can add a new song, showcasing the versatility enabled by the Strategy pattern.

  
<img width="332" alt="Concrete_Strategy" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/9804fc8f-5c23-4a88-80cb-2bf0300ba48d">

_Screenshot 4 Concrete Strategy_


<img width="408" alt="Context" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/70543481-2ad4-4646-9796-e79bfe6a06a8">

_Screenshot 5 Context_

  

**Decorator Pattern: Augmenting User Access Levels**

  

The Decorator pattern is employed to dynamically enhance user access levels. The `IAccessLevelDecorator` interface, along with concrete decorators like `PremiumAccessDecorator` and `UltraAccessDecorator`, empowers users with upgraded privileges. This pattern enhances extensibility, enabling the addition of access level features without modifying the core `User` class.

  
<img width="620" alt="Concrete_decorator" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/ec6dbc18-4342-433a-9afe-492cfe694877">

_Screenshot 6 Concrete Decorator_

  

**Adapter Pattern: Bridging Currency Payments**

  

The Adapter pattern is utilized to seamlessly integrate different payment methods. The `DollarToTengeAdapter` acts as a bridge, allowing the `PaymentMachine` to process payments in both dollars and tenge uniformly. This adaptability enhances the system's robustness, accommodating diverse payment options without modifying existing components.

  
<img width="666" alt="Adapter" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/74470636-dec6-419b-9ee4-75643cba2f97">

_Screenshot 7 Adapter_


<img width="374" alt="Adaptee" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/2d7b6daf-cd26-43bd-9fa5-fdaf576dbfe2">

_Screenshot 8 Adaptee_

  

**Factory Pattern: Dynamic Content Creation**

  

The Factory pattern is integral to the dynamic creation of content. Concrete factories like `MusicFactory` and `PodcastFactory` implement the `IStrategy` interface, providing a unified method (`action`) for creating content instances. For instance, the `Singer` class utilizes the `MusicFactory` to create songs based on user input.

  
<img width="543" alt="Concrete_Factory" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/06b3e496-7062-48b0-816e-af59d418f06d">

_Screenshot 9 Concrete Factory_


<img width="411" alt="Concrete_product" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/1e910ee7-b5f3-4e60-a345-45c40395aa43">

_Screenshot 10 Concrete Product_

  

**Main Features**

  

·      User Authentication and Authorization: Users can sign in or sign up with different roles (Listener, Singer, Podcaster) and are authorized based on their roles to perform specific actions.

·      Content Creation and Storage: Singers can add music, Podcasters can add podcasts, and Listeners can upgrade their access levels. The content is stored in the PostgreSQL database.

·      Payment Processing: Listeners can upgrade their access levels by making payments, demonstrating the integration of the Observer pattern in the payment system.

·      Dynamic Content Listening: Listeners can listen to music or podcasts based on their access levels, showcasing the Strategy pattern.

  

**PostreSQL Database**

  
<img width="506" alt="ERD" src="https://github.com/whateveer/FinalProjectSDP/assets/66480258/ca588b09-ad43-497e-933d-73f1984e3726">

_Entity Relationship Diagram_

**Conclusion**

  

**Summary**

  

In conclusion, the multimedia content management system project serves as a testament to the seamless integration of theoretical principles and practical insights gained from software design and Database Management Systems (DBMS) courses. Key design patterns include Observer for payment notifications, Singleton for database connection management, Strategy for dynamic content creation, Decorator for access level enhancements, and Adapter for payment system compatibility.

  

**Challenges Faced**

  

·      Integrating the database connection using the Singleton pattern required careful consideration of exception handling and error management during connection establishment.

·      Implementing decorators for user access levels involved addressing challenges related to the dynamic composition of access level features.

  

**Future Improvements**

  

·      Implementing additional security measures, such as encryption for user credentials and content or SQL injection prevention, to ensure the protection of sensitive information.

·      Improving the user interface to enhance user experience and provide a more intuitive interaction with the multimedia content management system, by adding GUI.

·      Incorporating advanced content filtering options based on user preferences and history to personalize content recommendations, and system of likes and dislikes correspondingly.

Overall, this project represents not only a project's completion, but a journey of progress, informed decision-making, and practical application of acquired knowledge.

  

**References**

  

Refactoring Guru (n.d.). Retrieved November 21, 2023, from https://refactoring.guru/design-patterns

  

Stack Overflow. (n.d.). Retrieved November 21, 2023, from https://stackoverflow.com/
