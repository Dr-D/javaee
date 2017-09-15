# izpack installer

This is a simple maven project that uses the [izpack](http://izpack.org/) plugin to create an installer for a jar file.

## debugging
VM options

```-DDEBUG=true -DSTACKTRACE=true```

Turning this on shows the current state of all the variables.

## To Do
izpack can create windows installer and jar type installer
use variables/dynamic that can be passed between panels
Getting this error after adding userInputPanel ```com.izforge.izpack.installer.ResourceNotFoundException: Cannot find named Resource: '/res/userInputLang.xml_eng' AND '/res/userInputLang.xml_eng_eng'```