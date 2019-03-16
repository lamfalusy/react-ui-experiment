import React, {Component} from 'react';
import 'isomorphic-unfetch';

class Index extends Component {

	static async getInitialProps() {
		const res = await fetch("http://localhost:8080/api/assignee");
		const json = await res.json();
		return { json };
	}

	renderAssigneeItem = (item, index) => {
		return (
			<tr key={index}>
				<td>{item.name}</td>
				<td>{item.role}</td>
			</tr>
		);
	};

	render() {
		const {json} = this.props;
		return (
			<main className="container">

				<h2>List of Assignees</h2>

				<table className="table">
					<thead>
					<tr>
						<th>Name</th>
						<th>Role</th>
					</tr>
					</thead>
					<tbody>
						{ json.map(this.renderAssigneeItem) }
					</tbody>
				</table>

			</main>
		);
	}
}

export default Index;