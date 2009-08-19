function insertSpamCheckString() {
	var field = document.getElementById( 'spamStringField' );

	if( field )
		field.value = "já";
	
	var commentArea = document.getElementById( 'comments' );

	if( commentArea ) {
		commentArea.value = commentArea.value.trim;
	}
	
}