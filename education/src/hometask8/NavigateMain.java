package hometask8;

import java.util.HashMap;

public class NavigateMain {

    public static void main(String[] args) {

        FileData file1 = new FileData("file1", 10, "/path/to/file1");
        FileData file2 = new FileData("file2", 9, "/path/to/file2");

        FileData file3 = new FileData("file3", 8, "/path/to/file3");
        FileData file33 = new FileData("file33", 4, "/path/to/file3");
        FileData file333 = new FileData("file333", 2, "/path/to/file3");

        FileData file4 = new FileData("file4", 12, "/path/to/file4");

        FileNavigator fileRepository = new FileNavigator(new HashMap<>());

//        add:
        fileRepository.add(file1, "/path/to/file1");
        fileRepository.add(file2, "/path/to/file2");
//        Key Path and File Path don't match:
        fileRepository.add(file3, "/path/to/file2");

        fileRepository.add(file33, "/path/to/file3");
        fileRepository.add(file333, "/path/to/file3");
        fileRepository.add(file4, "/path/to/file4");

        System.out.println(fileRepository);

        //find:
        System.out.println(fileRepository.find("/path/to/file3"));

        //filterBySize:
        System.out.println(fileRepository.filterBySize(11));

        //sortBySize:
        System.out.println(fileRepository.sortBySize());

        //remove:
        fileRepository.remove("/path/to/file3");
        System.out.println(fileRepository);
    }
}
