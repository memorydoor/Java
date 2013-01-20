package com.yong.groovy.closure

def clos = { println "hello!" }

println "Executing the Closure:"
clos()

i = 1

def prints = {a, b -> print a + b print " "+ i}

prints(1, 1)