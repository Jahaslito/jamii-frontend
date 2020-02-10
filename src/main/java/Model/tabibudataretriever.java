package Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class tabibudataretriever {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

tabibuPlaceholderAPI tabibuPlaceholderAPI = retrofit.create(tabibuPlaceholderAPI.class);

    Call<List<Post>> call = tabibuPlaceholderAPI.getPosts();

        call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

            if (!response.isSuccessful()) {
                textViewResult.setText("Code: " + response.code());
                return;
            }

            List<Post> posts = response.body();

            for (Post post : posts) {
                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "User ID: " + post.getUserId() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewResult.append(content);
            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            textViewResult.setText(t.getMessage());
        }
    });
}
}
}
