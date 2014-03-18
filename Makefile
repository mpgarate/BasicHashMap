JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
				HashNode.java \
				HashTable.java \
				ExampleCases.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java ExampleCases

clean:
	$(RM) *.class