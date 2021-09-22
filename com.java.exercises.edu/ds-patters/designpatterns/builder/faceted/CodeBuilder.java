package designpatterns.builder.faceted;

import java.util.ArrayList;
import java.util.List;

class ClassElement {
	String name;
	List<AttributeElement> attributes = new ArrayList<>();
}

class AttributeElement {
	String name;
	String type;
	public AttributeElement(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
}

public class CodeBuilder
{
	ClassElement classElment = new ClassElement();
	
    public CodeBuilder(String className)
    {
    	classElment.name = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
    	classElment.attributes.add(new AttributeElement(name, type));
    	return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("public class %s", classElment.name));
        builder.append("\n{ \n");
        for(AttributeElement element : classElment.attributes) {
        	builder.append(String.format("   public %s %s \n",element.name, element.type));
        }
        builder.append("\n} \n");
        return builder.toString();
    }
    
    public static void main(String[] args) {
    	CodeBuilder builder = new CodeBuilder("Person")
    			.addField("String", "name")
    			.addField("int", "age");
    	System.out.println(builder);
    }
}
