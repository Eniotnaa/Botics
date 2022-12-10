package Interface;

import Entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Connexion {
    @POST("/Connexion.php")
    Call<User> sendUser(@Body User body);
}
