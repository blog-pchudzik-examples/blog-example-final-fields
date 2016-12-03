package com.pchudzik.blog.immutable;

import java.lang.reflect.Field;

import static java.util.Arrays.asList;

class ImmutableExample {
	public static void main(String[] args) throws Exception {
		final ImmutableObject object = new ImmutableObject();

		final Field stringField = ImmutableObject.class.getDeclaredField("stringField");
		final Field longObjectField = ImmutableObject.class.getDeclaredField("longObjectField");
		final Field primitiveLongField = ImmutableObject.class.getDeclaredField("primitiveLong");

		asList(stringField, longObjectField, primitiveLongField).forEach(f -> f.setAccessible(true));

		stringField.set(object, "Yes I can");
		longObjectField.set(object, 11L);
		primitiveLongField.set(object, 21L);

		System.out.println("field access");
		System.out.println("string         = " + stringField.get(object));
		System.out.println("long object    = " + longObjectField.get(object));
		System.out.println("primitive long = " + primitiveLongField.get(object));

		System.out.println("getters:");
		System.out.println("toString       = " + object.toString());
		System.out.println("string         = " + object.getStringField());
		System.out.println("long object    = " + object.getLongObjectField());
		System.out.println("primitive long = " + object.getPrimitiveLong());
	}

	static class ImmutableObject {
		private final String stringField = "can't touch this";
		private final Long longObjectField = 10L;
		private final long primitiveLong = 20L;

		public Long getLongObjectField() {
			return longObjectField;
		}

		public String getStringField() {
			return stringField;
		}

		public long getPrimitiveLong() {
			return primitiveLong;
		}

		@Override
		public String toString() {
			return "string=" + stringField + ",longObjectField=" + longObjectField + ",primitiveLong=" + primitiveLong;
		}
	}
}
