package com.pchudzik.blog.immutable;

public class ByteCodeTest {
	private Long number = 10L;
	private final String inlined = "String to be inlined";

	public String getInlined() {
		return inlined;
	}

	public Long getNumber() {
		return number;
	}
}
