# Compilation:
rm -rf target

mkdir target
javac -d ./target/ src/java/edu/school21/printer/*/*.java

# Run app
    # Usage: app <full path to bmp image> <char for white pixels> <char for black pixels>

# Example use:
    java -cp ./target edu.school21.printer.app.Program /Users/lechalme/Desktop/day_04_ex00/it.bmp . 0