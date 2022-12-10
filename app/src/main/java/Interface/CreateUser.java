package Interface;

import Entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreateUser {
    @POST("/CreateUser.php")
    Call<User> sendUser(@Body User body);
}
