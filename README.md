## 1/ Introduction
The purpose of InventUrStock is to allow registered users, specifically a business or organization, to keep and manage inventory of any department or items you need to keep track of. InventUrStock provides a user-friendly experience with the use of visuals and animations to replicate our modern-day applications. The design of the app is very simplistic and easy to follow. Our inventory management system is protected, especially being a web database, the access to the inventory is locked from the public’s eyes. Access to the database is through a registered account. Account verification is through email. The only users that will be able to access, register and login to InventUrStock would be under the companies that have requested in use of the app or companies that the app has been supplied to.
<br/><br/>


## 2/ List of controls used and their purposes
<details><summary>Click to open</summary><br/>
  
### &emsp; 2.1/ External controls and uses implemented into Android Studio
<details><summary>Click to open</summary>

<br/><br/>
_____________________________________________________________________________________________________________________
> recyclerView<br/>

Used to display the inventory, allows user to interact and items in
inventory. 
+ Used in (`ViewItemsEdit.java`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Liquid Pager / Liquid Swipe<br/>

Used to display three (3) fragment activity that explains a few features about InventUrStock. 
+ Used in (`activity_main.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Kotlin to Java converter<br/>

Used with Liquid Pager to convert the functions from Kotlin to Java.

<br/><br/>
_____________________________________________________________________________________________________________________
> Floating Action Button<br/>

Used to have a small and stylish clickable button that will redirect you to the ViewItemsEdit activity to access edit mode for the inventory data.
+ Used in (`ViewItems`)
  
Used to redirect to the AddItems activity to add more inventory.
+ Used in (`ViewItemsEdit`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Gif image<br/>

Used to give a stylish, modern, and movable splash activity.
+ Used in (`activity_main.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase<br/>

Google's Firebase framework allows developers to create mobile and web apps.

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase Realtime Database<br/>

Used to have a location to store all user accounts and their details, as well as any inventory the users requested to keep stock of through the AddItems activity.

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase Authentication<br/>

Used to assist the user login, registration, and password change activities with their custom functions.
+ Used in (`RegisterPage.java`) (`LoginActivity.java`) (`ChangePassword.java`) (`ForgotPassword.java`)
</details><br/>

### &emsp; 2.2/ Internal controls and uses in Android Studio
<details><summary>Click to open</summary>

<br/><br/>
_____________________________________________________________________________________________________________________
> ProgressBar<br/>

Used to show duration of task initiated. 
+ Used in (`activity_login.xml`) (`activity_register_page.xml`) (`activity_change_password.xml`) (`activity_forgot_password.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> ImageView<br/>

Used for fragment activity page indicator.
+ Used in (`fragment_on_boarding1.xml`) (`fragment_on_boarding2.xml`) (`fragment_on_boarding3.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
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
<details><summary>Click to open</summary><br/>

The Database was created to house all the data sent from the app. I split the data into 2 different categories using nodes `Inventory` and `Users`. Each node has child nodes that capture important information for the rest of the application to run off of.<br/>

Each record added is added under a `UID (Unique Identification Number)`, this is done to make sure no 2 records are ever the same.<br/>

> _____________________________________________________________________________________________________________________
  
> ![image](https://github.com/user-attachments/assets/9b59d162-ce28-4175-9093-988e1167f81e)

> _____________________________________________________________________________________________________________________

> Inventory captures these fields as illustrated in the above screenshot:
- `added_by`: User who added the record to the database.
- `barcode`: Barcode of the item.
- `category`: Category of item.
- `price`: Set price of the item.
- `product`: Full product name.

> Users captures these fields as illustrated in the above screenshot:
- `Uname`: Username of created account.
- `email`: Email associated with created account.
- `pass`: Password set for the account.

<br/>

</details>
  
### &emsp; 3.2/ ADDED ACCOUNT AND INVENTORY DATA
<details><summary>Click to open</summary><br/>

When a user creates an account, a new `UID` is then created and added under the appropriate node.<br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/72208499-e007-4e29-b1ea-0cb8f1cd72b6)

<br/>

The same concept goes for added a new record to the inventory.<br/>

> ![image](https://github.com/user-attachments/assets/49baf31c-9a7d-448b-9689-e89794c9cf02)

> _____________________________________________________________________________________________________________________

<br/>

</details>

### &emsp; 3.3/ ACCOUNT AND INVENTORY DELETION
<details><summary>Click to open</summary><br/>

When a user chooses to delete an account, the `UID` tied to the account is then called from the database. Its used to ensure the correct account is being removed and no other.<br/>

> _____________________________________________________________________________________________________________________
  
> ![image](https://github.com/user-attachments/assets/09d105a3-a45e-4df8-81f8-4c478db39ec2)

<br/>

The same concept goes for deleting a record in inventory.<br/>

> ![image](https://github.com/user-attachments/assets/fd0e4b22-ddb3-4da8-ae59-200a8eff603f)

> _____________________________________________________________________________________________________________________

<br/>

</details>

### &emsp; 3.4/ INVENTORY OVERRITE
<details><summary>Click to open</summary><br/>

Data within the database can be overwritten if a password, email, record data is changed. This function utilizes the same `UID` concept as before with the account or record creation.<br/>

> _____________________________________________________________________________________________________________________
  
> ![image](https://github.com/user-attachments/assets/5a6e7d26-fcc8-4edf-8f59-edc8abb7e547)

> _____________________________________________________________________________________________________________________

<br/>

</details>

</details><br/><br/>


## 4/ Output screenshots of application running
<details><summary>Click to open</summary>
  
### &emsp; 4.1/ Splash screen start
<details><summary>Click to open</summary><br/>

![image](https://miro.medium.com/v2/resize:fit:2000/format:webp/1*WNv2vYX_vB2RA_O43Phrmw.gif)

I do not own this gif, if the original owner wishes for it to be taken down please reach out to my email: draymcfarlane@gmail.com<br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/bf99be7c-0a43-4dca-b806-3d090723cb7b)

> _____________________________________________________________________________________________________________________

<br/>

</details>
  
### &emsp; 4.2/ Fragment liquid slider
<details><summary>Click to open</summary><br/>

Below is an example of how this functions from [geeksforgeeks](https://www.geeksforgeeks.org/liquid-swipe-animation-in-android/)

![image](https://media.geeksforgeeks.org/wp-content/uploads/20210301114737/LiquidSwipeAnimationinAndroid.gif)

> _____________________________________________________________________________________________________________________

What it looks like in the app, just provides basic information. I provided a skip button at the top right to bypass all the pages and take you straight to the login screen. There is a nifty page counter at the bottom left as well.<br/>
> ![image](https://github.com/user-attachments/assets/f6d369cb-eb4b-423c-87ee-ab3013dc2490)

<br/>

What each fragment looks like:<br/>
`fragment_on_boarding1.xml`<br/>
> ![image](https://github.com/user-attachments/assets/91f4703b-a45a-41e4-aee5-685f3f348f70)

`fragment_on_boarding2.xml`<br/>
> ![image](https://github.com/user-attachments/assets/40c88b2b-2b66-448e-a3ad-5110660f6ad0)

`fragment_on_boarding3.xml`<br/>
> ![image](https://github.com/user-attachments/assets/e2958a4b-a547-4a19-92b1-e485b4c5fcd5)

> _____________________________________________________________________________________________________________________

<br/>

</details>

### &emsp; 4.3/ Account registration
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/658e7b89-809b-4db3-9364-9c60fabea24b)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/eedf34d3-242a-4c24-8a9e-9ed6f1738a53)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.4/ Email verification
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/e2094d86-48c3-45f1-80b0-ceb567f610ee)

> _____________________________________________________________________________________________________________________

### &emsp; &emsp; 4.4.1/ Email sent
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/85df95fc-196a-44e8-8d87-55b8dccabf8a)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; &emsp; 4.4.2/ After clicking on link
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/808dfcd1-ba8d-47df-8d67-1ee5120beb02)

> _____________________________________________________________________________________________________________________

</details><br/><br/>

</details>

### &emsp; 4.5/ Inventory menu
<details><summary>Click to open</summary><br/>
  
> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/5a9c96fd-c5e1-43c5-9a1e-117fa9cb95ea)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.6/ Viewing the profile
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/d3dce926-2a58-4f07-8c61-72d1116a1dda)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.7/ Returned to the menu, add new items
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/430ec289-a2c4-42bd-8a65-75c947d314d7)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/a4642f64-77e1-4365-9ad3-816eb257bc3f)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.8/ Viewing all items
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/4a411ae1-c338-43eb-a816-7ad41c7ac636)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.9/ Deleting new addition, accessed by clicking edit button at the bottom right
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/879112be-f1ff-4e10-9861-e1dfd7185882)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.10/ Exit edit mode button returns to previous activity displaying a non-interactable List View
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/879fb574-bc1e-4bd3-b109-001920a8265b)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.11/ Adding new data, accessed by clicking plus button at the bottom right in edit activity
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/eeb9c29f-5043-4684-998d-d37363f2b983)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.12/ Change / Forgot Password 
<details><summary>Click to open</summary><br/>
Both activities are practically the same. Only difference is when clicking the return to menu button, one returns you to your account display (Change Password since you are already in the account), and the other returns you to login (Forgot Password since you are not in the account). I could have set it to one activity controlling the password reset, though in the case of the user logged in accidently clicking it, they would not want to be logged out just trying to return to their account display<br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/c547694d-8d60-47bb-a424-faef212ab646)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/ef74b03e-2143-4349-8ad2-4a94189e3e86)

> _____________________________________________________________________________________________________________________

</details>
 
### &emsp; 4.13/ Email sent
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/c18d24d8-1909-41ed-91b0-53977898377f)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.14/ After clicking link
<details><summary>Click to open</summary><br/>
Sadly, a limitation with Firebase is that their password strength reset conditions don't seem to be configurable. That said, the minimum length requirement is only 6<br/>
  
> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/49f0f5e0-7abc-428b-8b28-551140be5371)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/b797712a-5954-49b1-8768-a21d15600687)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.15/ Old pass no longer works
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/4b2788c1-9fd1-4243-b283-b542f5c1561e)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.16/ New pass
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/83ddd5d4-b70d-4d13-95e5-76116d2c577d)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/75be070e-7901-4fa5-a646-c3ab5f89a824)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.17/ Account deleting
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/29fcdb0f-5a07-42f8-8395-3bdd2a0127d0)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/3e85483a-36df-4123-991b-6bfb9a73fc08)

> _____________________________________________________________________________________________________________________

</details>

### &emsp; 4.18/ Data can be displayed showing which user in the company entered it
<details><summary>Click to open</summary><br/>

> _____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/8849527b-fecc-4061-8a89-69b85a610b92)

> _____________________________________________________________________________________________________________________

</details>

</details><br/><br/>


## 5/ Conclusion

Throughout the production time of this application, I have learned many skills that I began practicing and utilizing in my free time. I was introduced to several functions and topics such as databases, liquid swipes, XML as a custom layout in List and Recycler Views, etc. Overall, I can say I am proud of the application I built and the skills that I have obtained, though there are some changes that I would've liked to make, as well as implementations. These consist of:


-	Reworking the password display TextView in the ViewProfile activity to show updated password instead of the password created with the account. I initially tried working on this error before submission, though I fell short of solutions as well as internet assistance.

-	Adding a search bar to navigate the List and Recycler Views faster. I have implemented this feature before, but I quickly deleted it as it did not filter search the Views at all.

-	An undo function in editing mode. This is another feature I tried to implement but deleted after as it did not collect and held the data deleted for recovering in the recyclerView.

-	Email change or update function. This was a function I have not tried to implement, though it would add more to the users experience as they would not have to create a new account for their new email. They would be able to keep their account details after changing the email address.

-	Admin account. This will benefit the organization more when using the app as they will have an admin account (each company will have a respective admin account) where they can manage their own inventory and users. Not only will they be able to delete inventory, but they will also be able to delete users accounts through a recyclerView.
