function sendDeleteRequest(url, redirectUrl) {
  $.ajax({
      url: url,
      method: "DELETE",
      success: function() {
        window.location = redirectUrl;
      },
      error: function() {
        window.location.reload();
      }
  });
}