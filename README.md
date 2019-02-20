# MorseCode
CPT-287 Project #3 Creating a morse code decoder/encoder using a binary tree.

James Bialon, Sean Stewart, Thomas Hopkins, Michael Steffens

# Contributing
* Make comments. The final project should be 20% comments as per instructor guidelines.
  * Comments describing a function/method should be done as follows: 
    ```java
    /**
     * This method preforms this function
     * @param parameter1 Type
     * @param parameter2 Type
     */
     public function() { } 
    ```
  * Other comments may be done inline if the function descriptor does not provide enough context
* Keep code as clean as possible 
  * Minimize messy whitespace
  
# Todo
* Morse code binary tree as specified:
	* depth 4
	* root stores nothing
	* left depth 1 stores 'e' (.)
	* right depth 1 stores 't' (-)
	* continue with dots towards left and dashes towards right
* Input file 
	* line consists of letter followed by code ( e . )
	* not necessarily organized for binary tree
* decode a message using the binary tree
	* space delimeter
* encode a message using binary tree 
* let user enter string from keyboard
	* encode and then decode it outputting both