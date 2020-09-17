package webservice;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String greeting(String name) {
        return "你好 "+name;
    }

    @Override
    public String print() {
        return "my name is xxx";
    }
}
