## 1/ Introduction
The purpose of InventUrStock is to allow registered users, specifically a business or organization, to keep and manage inventory of any department or items you need to keep track of. InventUrStock provides a user-friendly experience with the use of visuals and animations to replicate our modern-day applications. The design of the app is very simplistic and easy to follow. Our inventory management system is protected, especially being a web database, the access to the inventory is locked from the public’s eyes. Access to the database is through a registered account. Account verification is through email. The only users that will be able to access, register and login to InventUrStock would be under the companies that have requested in use of the app or companies that the app has been supplied to.
<br/><br/>


## 2/ List of controls used and their purposes
<details><summary>Click to open</summary><br/>
  
### &emsp; 2.1/ External controls and uses implemented into Android Studio
<details><summary>Click to open</summary>

<br/><br/>
> recyclerView<br/>

Used to display the inventory, allows user to interact and items in
inventory. 
+ Used in (`ViewItemsEdit.java`)

<br/><br/>
> Liquid Pager / Liquid Swipe<br/>

Used to display three (3) fragment activity that explains a few features about InventUrStock. 
+ Used in (`activity_main.xml`)

<br/><br/>
> Kotlin to Java converter<br/>

Used with Liquid Pager to convert the functions from Kotlin to Java.

<br/><br/>
> Floating Action Button<br/>

Used to have a small and stylish clickable button that will redirect you to the ViewItemsEdit activity to access edit mode for the inventory data.
+ Used in (`ViewItems`)
  
Used to redirect to the AddItems activity to add more inventory.
+ Used in (`ViewItemsEdit`)

<br/><br/>
> Gif image<br/>

Used to give a stylish, modern, and movable splash activity.
+ Used in (`activity_main.xml`)

<br/><br/>
> Firebase<br/>

Google's Firebase framework allows developers to create mobile and web apps.

<br/><br/>
> Firebase Realtime Database<br/>

Used to have a location to store all user accounts and their details, as well as any inventory the users requested to keep stock of through the AddItems activity.

<br/><br/>
> Firebase Authentication<br/>

Used to assist the user login, registration, and password change activities with their custom functions.
+ Used in (`RegisterPage.java`) (`LoginActivity.java`) (`ChangePassword.java`) (`ForgotPassword.java`)
</details><br/>

### &emsp; 2.2/ Internal controls and uses in Android Studio
<details><summary>Click to open</summary>

<br/><br/>
> ProgressBar<br/>

Used to show duration of task initiated. 
+ Used in (`activity_login.xml`) (`activity_register_page.xml`) (`activity_change_password.xml`) (`activity_forgot_password.xml`)

<br/><br/>
> ImageView<br/>

Used for fragment activity page indicator.
+ Used in (`fragment_on_boarding1.xml`) (`fragment_on_boarding2.xml`) (`fragment_on_boarding3.xml`)

<br/><br/>
> TextView<br/>

Majority were used as animated backgrounds, either white or dark gray.
+ Used in (`All Activity xml’s`)
  
Used as titles in activities such as “InventUrStock” or “Registration”. 
+ Used in (`All Activity xml’s`)
  
Used to display information about InventUrStock. 
+ Used in (`fragment_on_boarding1.xml`) (`fragment_on_boarding2.xml`) (`fragment_on_boarding3.xml`)
  
Used for a user greeting when in the inventory menu. 
+ Used in (`activity_inventory_page.xml`)
</details>

</details><br/><br/>


## 3/ Database Photos

<details><summary>Click to open</summary><br/>

### &emsp; 3.1/ OPENED AND CLOSED NODES IN DATABASE
<details><summary>Click to open</summary>
  
  ![OPENED AND CLOSED NODES IN DATABASE](https://github.com/user-attachments/assets/8fa84147-432b-4589-b7dc-c6025c8c151d)

</details>
  
### &emsp; 3.2/ ADDED ACCOUNT AND INVENTORY DATA
<details><summary>Click to open</summary>
  
  ![ADDED ACCOUNT AND INVENTORY DATA](https://github.com/user-attachments/assets/045dd5ff-a289-4cd7-823b-a54c0b14bbf3)<br/><br/>
  ![ADDED ACCOUNT AND INVENTORY DATA](https://github.com/user-attachments/assets/717e5a99-3961-41bd-9ec8-98dccbd9c85f)

</details>

### &emsp; 3.3/ ACCOUNT AND INVENTORY DELETION
<details><summary>Click to open</summary>
  
  ![ACCOUNT AND INVENTORY DELETION](https://github.com/user-attachments/assets/1d1fc6fd-27bc-4122-80aa-4624f3d3e91a)<br/><br/>
  ![ACCOUNT AND INVENTORY DELETION](https://github.com/user-attachments/assets/c32765ce-d6b9-4601-87d2-8ed10f980653)

</details>

### &emsp; 3.4/ INVENTORY OVERRITE
<details><summary>Click to open</summary>
  
  ![INVENTORY OVERRITE](https://github.com/user-attachments/assets/bf3de3a4-4e79-4da0-9043-d8dbba20b21e)

</details>

</details>
