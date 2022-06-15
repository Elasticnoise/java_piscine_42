# Удаление дирректории, если она была создана ранее.
rm -rf target

# Создание директории target
mkdir target

# Копирование дирректории resources с изображением в target
cp -R src/resources target/.

# Компиляция *.java файлы в *.class с флагом -d(указать директорию куда положить файлы *.class)
javac -d ./target/ src/java/edu/school21/printer/*/*.java

# Архивация .class файлов в jar архив
jar cfm ./target/images_to_char_printer.jar src/manifest.txt -C target .

# Открытие прав доступа .jar файлу
chmod u+x target/images_to_char_printer.jar

# Исполнение через архив .jar
 java -jar target/images_to_char_printer.jar /Users/lechalme/Desktop/ImagesToChar/src/java/edu/school21/printer/resources/image.bmp . 0