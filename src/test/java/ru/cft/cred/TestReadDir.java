package ru.cft.cred;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class TestReadDir {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path newLink = Paths.get("C:\\Documents and Settings\\babiiv\\web.xml");
		Path newLink2 = Paths.get("C:\\Users\\babiiv\\web.xml");
		Path newLink3 = Paths.get("C:\\Documents and Settings");
		Path newLink5 = Paths.get("C:\\");
		File file = new File("C:\\");
		File file2 = new File("C:\\Users\\babiiv\\web.xml");
		File file3 = new File("C:\\Users");
		String name = file.getName();
		System.out.println(name);
		if (name.equals("")) {
			name = file.getPath();
			System.out.println("!");
		}
		System.out.println(file.isDirectory());
		System.out.println(name);
		System.out.println(file.getPath());
		System.out.println(file2.getName());
		System.out.println(file3.getPath());
		System.out.println(newLink5.getFileName());
		System.out.println(newLink5.toRealPath().getParent());
		System.out.println(newLink2.toRealPath().getParent().toRealPath());
		System.out.println(newLink.toRealPath());
		System.out.println(newLink3.toRealPath().toAbsolutePath().toString());
		System.out.println(newLink3.toRealPath().getFileName());
		System.out.println(newLink3.toRealPath().getParent().toRealPath());
		System.out.println(Files.isSymbolicLink(newLink));
		System.out.println(Files.isSameFile(newLink, newLink2));
		Path newLink4 = Paths.get("C:\\TEMP\\1\\web.xml");
		System.out.println(newLink4.toRealPath());
		System.out.println(newLink4.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println(newLink4.toRealPath());
		System.out.println(Files.isSameFile(newLink2, newLink4));
		System.out.println(Files.isRegularFile(newLink4));
		System.out.println(Files.isSymbolicLink(newLink4));
		//Path link = Files.readSymbolicLink(newLink3);
		//System.out.println(link.toRealPath());
		System.out.println(Files.isRegularFile(newLink));
		System.out.println(Files.getAttribute(newLink4, "basic:fileKey"));
		System.out.println(Files.getAttribute(newLink2, "basic:fileKey"));
		/*System.out.println(Files.isSymbolicLink(newLink));
		File dir = new File("C:/TEMP");
		System.out.println(dir.getFreeSpace());
		System.out.println(dir.getFreeSpace());
		System.out.println(dir.getUsableSpace());
		System.out.println(dir.length());
		dir = new File("C:/2_ARM");
		System.out.println(dir.getFreeSpace());
		System.out.println(dir.getUsableSpace());
		System.out.println(dir.length());
		File file = new File("C:\\Documents and Settings");
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getFreeSpace());
		System.out.println(file.getUsableSpace());
		System.out.println(file.length());
		System.out.println(FileUtils.sizeOfDirectory(dir));
		System.out.println(FileUtils.byteCountToDisplaySize(FileUtils.sizeOfDirectory(dir)));
		File file2 = new File("C:\\Documents and Settings\\user\\web.xml");
		File file3 = new File("C:\\Users\\user\\web.xml");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getCanonicalPath());
		System.out.println(file2.getPath());
		System.out.println(file2.getParentFile().getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getCanonicalPath());
		System.out.println(file3.getPath());
		System.out.println(file3.getParentFile().getAbsolutePath());*/
		
//		FileSystem fs = FileSystems.getDefault();
//	    Iterable<Path> roots = fs.getRootDirectories();
//	    for (FileStore store: fs.getFileStores()) {
//        	System.out.println("Name: " + store.getAttribute("size"));
//	        Iterator<Path> i = roots.iterator();
//	        while(i.hasNext()) {
//	            if(store.name().startsWith(i.next().toString())) {
//	            	System.out.println("Name: " + store.name());
//	                //System.out.println("Name: " + store.name() + ", Read only: " + store.isReadOnly() + ", Type: " + store.type() + ", Block: " + store.getBlockSize() + " Bytes");
//	            }
//	        }
//	    }
	}

}
