# BooksApp

BooksApp was made in Kotlin (Android) and it has two-screens: The first one with a list of books from Google Api and the second one a list of books saved as favorites by the user. The user cas switch between them on the bottom sheet. The books are displayed on a list format and have two buttons: One to save the book as a favorite (this button switchs to delete the book on the favorites screen) and one to access the webpage to buy the book when this option is available).

## Architectural Pattern - MVVM
The architectural pattern chosen for the project was MVVM due to the clear separation of responsibilities. There are 3 layers to the project: The Data Layer (with the API mapping, user model and repository implementtion), the Domain Layer (with the repository interface and the get users use case) and the Presentation Layer (with the views). 

## Dependency Injection - Dagger Hilt
The Google library Dagger Hilt was used for dependency injection because of its flexibility and practical way of building the dependencies as Singletons and having a readable structure with modules.
