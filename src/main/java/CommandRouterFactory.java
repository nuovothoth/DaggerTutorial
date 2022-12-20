import dagger.Component;

@Component(modules = {HelloWorldModule.class, LoginCommandModule.class, UserCommandsModule.class, SystemOutModule.class})
interface CommandRouterFactory {
    CommandRouter router();
}
