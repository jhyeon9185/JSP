function confirmDelete(num){
    if(confirm("정말 삭제하시겠습니까?")){
        window.location.href = "ProductServlet?command=product_delete&num=" + num;
    }
}
