import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {HelloWorldModule.class, LoginCommandModule.class, UserCommandsModule.class, SystemOutModule.class})
interface CommandRouterFactory {
    CommandRouter router();
}
