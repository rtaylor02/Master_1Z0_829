package fileio.filesmethods;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

/**
 * Lesson 30.1 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code shows how to use paths and keep an eye on changes to a file.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //somePathMethods();
        
        //usingWatchService();
        
        readingFileAttributes();
        
    }
    
    private static void readingPosixFileAttributes() throws IOException {
        var posixFileAttributes = Files.readAttributes(Path.of("./paths/a/b/file-a-b.txt"), PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        System.out.println("=========Reading PosixFileAttributes==============");
        System.out.println(posixFileAttributes);
        System.out.println(posixFileAttributes.isDirectory());
        System.out.println(posixFileAttributes.creationTime());
        System.out.println("=======================");
    }
    
    private static void readingFileAttributes() throws IOException {
        readBasicFileAttributes();
        
        readingPosixFileAttributes();
        
    }
    
    private static void readBasicFileAttributes() throws IOException {
        var basicFileAttributes = Files.readAttributes(Path.of("."), BasicFileAttributes.class);
        System.out.println("=========Reading BasicFileAttributes==============");
        System.out.println(basicFileAttributes);
        System.out.println(basicFileAttributes.isDirectory());
        System.out.println(basicFileAttributes.creationTime());
        System.out.println("=======================");
    }
    
    private static void usingWatchService() {
        try (var watchService = FileSystems.getDefault().newWatchService()) {
            Path pathsDirectory = Path.of("paths");
            var registrationKey = pathsDirectory.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            
            while (true) {
                var key = watchService.take(); // Blocking action
                System.out.println("something happened");
                for (var event : key.pollEvents()) {
                    System.out.println("file name: " + event.context());
                }
                registrationKey.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void somePathMethods() {
        Path abFile = Path.of("paths", "a", "b", "file-a-b.txt"); // No separator in the path
        Path cPath = Path.of("paths", "c");
        
        System.out.println(abFile.getFileName());
        System.out.println("element 2 is: " + abFile.getName(2));
        abFile.iterator().forEachRemaining(System.out::println);
        System.out.println("path is absolute?" + abFile.isAbsolute());
        System.out.println("absolute path is: " + abFile.toAbsolutePath());
        // Other methods: compareTo, startsWith, endsWith, getParent, getRoot, subPath, toFile, etc
        
        Path odd = Path.of(".", "..", "Master_1Z0_829", "paths", "a", "b", "file-a-b.txt");
        System.out.println("odd is: " + odd);
        System.out.println("normalised is: " + odd.normalize());
        
        System.out.println("Resolve, joining paths: " + cPath.resolve("d/file-c-d.txt"));
        System.out.println("To get from paths/c to file-a-b.txt: " + cPath.relativize(abFile));
    }
}
