import react, {Component} from 'react';
import Head from 'next/head'

class Meta extends Component{
	render() {
		return (
			<Head>
				<title>Task Manager</title>
				<meta httpEquiv="Content-Type" content="text/html; charset=UTF-8" />

				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
					  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
					  crossorigin="anonymous"/>

			</Head>
		);
	}
}

export default Meta;