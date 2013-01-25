class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/index4"(view:"/index")
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
