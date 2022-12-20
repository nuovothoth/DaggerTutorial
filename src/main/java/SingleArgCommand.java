import java.util.List;

abstract class SingleArgCommand implements Command {
    /*@Override
    public final Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
    }

    protected abstract Result handleArg(String arg);*/

    @Override
    public final Status handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
    }

    protected abstract Status handleArg(String arg);
}
