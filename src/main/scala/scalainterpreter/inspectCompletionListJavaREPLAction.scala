
package  scalainterpreter


import java.awt.event.ActionEvent
import scalaExec.Interpreter.GlobalValues

class inspectCompletionListJavaREPLAction() extends javax.swing.AbstractAction() {
   

   override def actionPerformed(  e: ActionEvent ) {
         
         var editor = scalaExec.Interpreter.GlobalValues.editorPane   // get editor instance
         
         var pos = editor.getCaretPosition-1  
         var doc = editor.getDocument()
      
        GlobalValues.methodNameSpecified = false
        GlobalValues.selectionStart = -1
       
       var exited = false
        // take word part before cursor position
       var wb = ""
       var offset = pos
       while (offset >= 0 && exited==false) {
         var ch = doc.getText(offset, 1).charAt(0)
          if (ch == '.') {
               GlobalValues.methodNameSpecified = true;
               GlobalValues.selectionStart = offset+1;   // replace the text after '.'
          }

         var isalphaNumeric = ( ch >= 'a' && ch <='z')  || (ch >= 'A' && ch <='Z') || (ch >= '0' && ch <='9') || ch=='.'  || ch=='_' || ch=='$'
         if (!isalphaNumeric)  exited=true
          else {
           wb = wb + ch
           offset -= 1
           }
      }
          
    GlobalValues.selectionBeginning = offset+1; // keep the identifier start for static members completion 

    if (GlobalValues.selectionStart == -1)  // a method name is not specified, thus set selection start to the beginning of the word
      GlobalValues.selectionStart = pos+1
        
    // take word part after cursor position
       var wa = ""
       var docLen = doc.getLength()
       offset = pos+1
       exited = false
       while (offset < docLen && exited==false) {
         var ch = doc.getText(offset, 1).charAt(0)
         var isalphaNumeric = ( ch >= 'a' && ch <='z')  || (ch >= 'A' && ch <='Z') || (ch >= '0' && ch <='9') || ch=='.' || ch=='_' || ch=='$'
         if (!isalphaNumeric)  exited=true
           else {
         wa = wa + ch
         offset += 1
           }
         }
        
       GlobalValues.selectionEnd = offset
           
      //   form total word that is under caret position
         var wordAtCursor = wb.reverse+wa       
         
    //println("wordAtCursor = "+wordAtCursor)
          
           var sc = scalaExec.Interpreter.GlobalValues.globalSimpleConsole

           var r = sc.completion(wordAtCursor)
           scalaSciCommands.Inspect.inspectCompletionListREPL(r.candidates)
           println(r.candidates)
     
            }  // actionPerformed
    }
    
         
