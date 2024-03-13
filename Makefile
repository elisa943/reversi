CC=javac
FILE=main

all: $(FILE)
	@echo "Construction de la classe."

$(FILE):
	$(CC) $(FILE).java
	java $(FILE)

clean:
	rm -f *.class