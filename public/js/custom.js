function sendDeleteRequest(url, redirectUrl) {
    //Create a DELETE request
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

function sendPutRequest(formId, redirectUrl) {
    // Morph given form into a variable
    var form = $('#'+formId);
    // Use the form to create a PUT request
    $.ajax({
        url: form.attr('action'),
        method: "PUT",
        data: form.serialize(),
        success: function () {
            window.location = redirectUrl;
        },
        error: function() {
            window.location.reload();
        }
    });
}