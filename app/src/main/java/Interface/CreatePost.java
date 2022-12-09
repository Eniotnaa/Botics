package Interface;

import Entity.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreatePost {
    @POST("/CreatePost.php")
    Call<Post> sendPost(@Body Post body);
}
