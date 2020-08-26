package IO;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static int numberOfHyphensBeforeName = 1;
    private static int numberOfSpacesBeforeName = 0;
    private static ArrayList<String> listWithNameFiles = new ArrayList<>();
    private static int countFiles = 0;
    private static int countDirectories = 0;
    private static int totalLengthNamesOfFiles = 0;
    private static FileWriter writer;

    public static void main(String[] args) {
        String pathFile = new File("").getAbsolutePath();
        int placeOfAppearanceInPath = pathFile.indexOf("Java.EPAM");
        pathFile = pathFile.substring(0, placeOfAppearanceInPath) + "Java.EPAM\\src\\main\\java\\IO\\output\\Main.txt";

        try {
            writer = new FileWriter(pathFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert the path to directory or file.");
            File workingDirectory = new File(reader.readLine());
            File parentDir = new File(workingDirectory.getParent());

            if (workingDirectory.isFile() || workingDirectory.isDirectory()) {
                if (workingDirectory.isFile()) {
                    if (getFileExtension(workingDirectory).equals(".txt")) {
                        getInformationAboutTree(parentDir);
                        try {
                            writer.write("Count of directories " + countDirectories + "\n" +
                                    "Count of files " + countFiles + "\n" +
                                    "Middle count files in directory " + (double) countFiles/countDirectories + "\n" +
                                    "Middle length name of file " + getMiddleLengthNamesOfFiles(parentDir));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else System.out.println("The specified file does't have a .txt extension.");
                } else getTreeDirectory(workingDirectory);
            }
            else System.out.println("This path does't exist.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("Information add in Java.EPAM/src/main/java/IO/output/Main.txt");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getTreeDirectory(File dir) throws IOException {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    printStructureDirectory(file);
                    numberOfHyphensBeforeName++;
                    numberOfSpacesBeforeName++;
                    getTreeDirectory(file);
                }
                else if (file.isFile()) {
                    printStructureDirectory(file);
                }
            }
            numberOfHyphensBeforeName--;
            numberOfSpacesBeforeName--;
        }

    private static void printStructureDirectory(File file) throws IOException {
            if (file.isFile()) {
                for (int i = 0; i < numberOfSpacesBeforeName; i++) {
                    writer.write(" ");
                }
                for (int i = 0; i < numberOfHyphensBeforeName; i++) {
                    writer.write("-");
                }
                writer.write(" " + file.getName() + "\n");
            } else if (file.isDirectory()) {
                for (int i = 0; i < numberOfSpacesBeforeName; i++) {
                    writer.write(" ");
                }
                writer.write("|");
                for (int i = 0; i < numberOfHyphensBeforeName; i++) {
                    writer.write("-");
                }
                writer.write(" " + file.getName() + "\n");
            }
        }

    private static void getInformationAboutTree(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isFile()) countFiles++;
            else if (file.isDirectory()) {
                countDirectories++;
                getInformationAboutTree(file);
            }
        }
    }

    private static double getMiddleLengthNamesOfFiles(File dir){
        getListWithLengthNamesOfFiles(dir);
        for (String lengthFiles : listWithNameFiles){
            totalLengthNamesOfFiles += lengthFiles.length();
        }
        return (double) totalLengthNamesOfFiles / listWithNameFiles.size();
    }

    private static void getListWithLengthNamesOfFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                listWithNameFiles.add(file.getName());
            }
            else if (file.isDirectory())
            {
                getListWithLengthNamesOfFiles(file);
            }
        }
    }

    private static String getFileExtension(File file) {
        String nameFile = file.getName();
        int index = nameFile.lastIndexOf('.');
        return nameFile.substring(index);
    }
}