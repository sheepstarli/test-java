package enumtest;

public class Test {

	public static void main(String[] args) {
		CharacterProfileField[] fields = CharacterProfileField.values();
		StringBuilder builder = new StringBuilder();
		builder.append("select o.characterid,");
		for(CharacterProfileField field : fields) {
			builder.append("o.").append(field.value).append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(" from CharacterProfileDetail o where o.characterid=?");
		System.out.println(builder.toString());
	}

}
