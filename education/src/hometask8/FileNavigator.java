package hometask8;

import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> fileRepository;

    public FileNavigator(Map<String, List<FileData>> fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void add(FileData newFile, String keyPath) {
        if (keyPath.equals(newFile.getPath())) {
            if (fileRepository.containsKey(keyPath)) {
                fileRepository.get(keyPath).add(newFile);
            } else {
                fileRepository.put(keyPath, new ArrayList<>());
                fileRepository.get(keyPath).add(newFile);
            }
        } else {
            System.out.println("Key Path and File Path don't match");
        }
    }

    public List<FileData> find(String keyPath) {
        if (fileRepository.containsKey(keyPath)) {
            return fileRepository.get(keyPath);
        }
        return null;
    }

    public List<FileData> filterBySize(int byteSizeLimit) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> fileDir : fileRepository.values()) {
            for (FileData fileData : fileDir) {
                if (fileData.getSize() < byteSizeLimit) {
                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String keyPath) {
        fileRepository.remove(keyPath);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedFiles = new ArrayList<>();
        for (List<FileData> fileDir : fileRepository.values()) {
            sortedFiles.addAll(fileDir);
        }
        Comparator<FileData> comparator = (fileData1, fileData2) -> {
            if (fileData1.getSize() != fileData2.getSize()) {
                return fileData1.getSize() - fileData2.getSize();
            } else {
                return fileData1.getName().length() - fileData2.getName().length();
            }
        };
        sortedFiles.sort(comparator);
        return sortedFiles;
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileRepository=" + fileRepository +
                '}';
    }
}
