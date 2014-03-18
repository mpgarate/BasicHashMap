JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
				HashNode.java \
				HashTable.java \
				HashRunner.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java HashRunner

clean:
	$(RM) *.class