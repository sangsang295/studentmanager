window.addEventListener("load", () => {
	new Vue({
		el: "#nav",
		data() {
			return {
				lists: [

					{
						title: "加入",
						href: path + "/insert.jsp"
					},
					{
						title: "删除",
						href: path + "/dele.jsp"
					},
					{
						title: "修改",
						href: path + "/update.jsp"
					},
					{
						title: "查询",
						href: path + "/search.jsp"
					},
					{
						title: "全部",
						href: path + "/allShow.jsp"
					}
				]
			}
		},
		mounted() {
			
		},
		methods: {
			
		}
	});
});