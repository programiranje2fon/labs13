#Lab no. 13

##Problem 1
*(worked through by the TA with students' help)*

Write public class **TextDemo** in package **problem1.business_logic**, that has:

1. Public method **readText** that takes the name of the textual file as its input argument. This method
reads all text from that file and returns it as one String. If an error occurs during the execution,
or the file does not exist, this method should return null. The method should take care of the symbol
for the line end, which the return String should contain. If an error occurs during input, the method should throw an appropriate exception.

2. Public method **enterText** that accepts two Strings as its arguments: the file name, and some other text.
This method writes the provided text into the file determined by the first argument. If an error occurs during input, the method should throw an appropriate exception.

Create a visual class **TextEditorGUI** in package **problem1.gui**, that appears as displayed in the figure.
The central screen area should be the text editor. When the form is resized, this central part should be enlarged/shrinked, while other components should stay in place.


1. When the "Delete" button is clicked, the text from the editor should be erased.
![Editor Gui](editor-gui.png)

2. When the "Read" button is clicked, the name of a text file should be taken from the input field, and the
text that it contains should be displayed in the editor. Reading should be done using the methods from
class **TextDemo**.

3. When the "Save" button is clicked, the text that is displayed in the editor should be saved in the file whose
name is in the input field. Reading and writing should be done by calling the methods from the class TextDemo.
Reading should be done using the methods from
class **TextDemo**.

4 When the "Replace" menu item is clicked, a dialog should open, in which the user enters a string that
should be replaced, a string that should replace it, and then, after the **OK** button is clicked, replaces
all occurrences of the string in the text in the editor.

5. When the "Exit" button is clicked, the program execution halts. **(System.exit(0))**
