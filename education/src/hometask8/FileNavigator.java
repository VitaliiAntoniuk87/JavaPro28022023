package hometask8;

import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> repository = new HashMap<>();

    public void add(FileData file) {
        repository.computeIfAbsent(file.getPath(), k -> new ArrayList<>()).add(file);
//        if (repository.containsKey(file.getPath())) {
//            repository.get(file.getPath()).add(file);
//        } else {
//            ArrayList<FileData> files = new ArrayList<>();
//            files.add(file);
//            repository.put(file.getPath(), files);
//        }
    }

    public void add(FileData file, String path) {
        if (!file.getPath().equals(path)) {
            System.out.println("Incorrect path");
        }
        add(file);
    }

    public List<FileData> find(String path) {
        return repository.get(path);
    }

    public List<FileData> filterBySize(int size) {
        return repository.values().stream()
                .flatMap(Collection::stream)
                .filter(e -> e.getSize() < size)
                .toList();
//        ArrayList<FileData> result = new ArrayList<>();
//        for (List<FileData> files : repository.values()) {
//            for (FileData file : files) {
//                if (file.getSize() < size) {
//                    result.add(file);
//                }
//            }
//        }
//        return result;
    }

    public void remove(String path) {
        repository.remove(path);
    }

    public List<FileData> sortBySize() {
        return repository.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(FileData::getSize))
                .toList();
//        TreeSet<FileData> sortedFiles = new TreeSet<>(Comparator.comparingInt(FileData::getSize));
//        for (List<FileData> files : repository.values()) {
//            sortedFiles.addAll(files);
//        }
//        return new ArrayList<>(sortedFiles);
    }



}
