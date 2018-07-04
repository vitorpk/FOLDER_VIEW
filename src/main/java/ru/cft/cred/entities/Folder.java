package ru.cft.cred.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Folder {
	private String name;
	private String path;
	private String parent;
	private long size;
}
