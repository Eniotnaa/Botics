package Interface;

import java.util.List;

import Entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPost {
    @GET("GetPost.php")
    Call<List<Post>> getPost();
}
