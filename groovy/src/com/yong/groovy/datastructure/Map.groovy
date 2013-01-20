package com.yong.groovy.datastructure

map = [1:"a", 2:"b"]

m2 = map.findAll {key, value -> key > 1}

print m2