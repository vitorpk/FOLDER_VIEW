package ru.cft.cred.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Disk {
	private String name;
	private String path;
	private long freeSpace;
	private long totalSpace;
}
