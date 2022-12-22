import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
interface LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    Command loginCommand(LoginCommand command);

    @Binds
    @IntoMap
    @StringKey("logout")
    Command logoutCommand(LogoutCommand command);

    @BindsOptionalOf
    Database.Account optionalAccount();
}
