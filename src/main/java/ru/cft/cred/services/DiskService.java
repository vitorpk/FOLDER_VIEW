package ru.cft.cred.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.cft.cred.entities.Disk;

@Service
public class DiskService {

	public List<Disk> getDiskList() {
		
		List<Disk> diskList = new ArrayList<Disk>();
		
		File[] roots = File.listRoots();
		
		for (File file: roots) {
			diskList.add(Disk.builder()
					.freeSpace(file.getUsableSpace())
					.name(file.getAbsolutePath().substring(0, 1))
					.path(file.getAbsolutePath())
					.totalSpace(file.getTotalSpace())
					.build()
					);
		}
		
		return diskList;
	}
}
