# Java Thread: notify() and wait() examples

This project contains some code examples to demonstrate Java concurrency.  
By understanding them, you will have a better understanding about notify() and wait() methods.

### Issues

1. IllegalMonitorStateException on wait() call  
   You need to be in a synchronized block in order for Object.wait() to work.

### References

1. http://www.programcreek.com/2009/02/notify-and-wait-example/