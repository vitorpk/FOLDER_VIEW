package ru.cft.cred.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dir {
	private String name;
	private String path;
	private long size;
}
