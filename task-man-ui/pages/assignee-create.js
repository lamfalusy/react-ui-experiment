import React, {Component} from 'react';
import Router from 'next/router';
import 'isomorphic-unfetch';

class AssigneeCreate extends Component {

	state = {
		name: '',
		role: ''
	};

	static async getInitialProps() {
		const res = await fetch('http://localhost:8080/api/role');
		const roles = await res.json();
		return {roles};
	}

	renderRoleOption = (item, index) => {
		return (
			<option value={item} key={index}>{item}</option>
		);
	};

	handleChange = e => {
		this.setState({
			[e.target.name]: e.target.value
		});
	};

	handleClick = async e => {
		e.preventDefault();
		const {roles} = this.props;
		const {role} = this.state;
		const req = this.state;
		if(Object.is(role, null) || Object.is(role, undefined) || role.length <= 0) {
			req.role = roles[0];
		}
		const res = await fetch("http://localhost:8080/api/assignee",{
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				"Access-Control-Allow-Origin": "*"
			},
			body: JSON.stringify(req),
		});
		const json = await res.json();
		console.log(json);
		this.setState({
			name: '',
			role: ''
		});
		if(res.ok) {
			Router.push("/");
		} else {
			alert("You are fucked! :)");
		}
	};

	render() {
		const {roles} = this.props;
		const {name, role} = this.state;
		return (
			<main className="container">

				<div className="starter-template">

					<h2>Create Assignee</h2>

					<form action="#" method="post">
						<div className="form-group">
							<label htmlFor="name">Name</label>
							<input className="form-control" id="name" aria-describedby="nameHelp" name="name"
								   placeholder="Enter name" type="text" value={name} onChange={this.handleChange}/>
							<small id="nameHelp" className="form-text text-muted">Name of the assignee. Mandatory
								field.
							</small>
						</div>
						<div className="form-group">
							<select className="form-control" name="role" value={role} onChange={this.handleChange}>
								{roles.map(this.renderRoleOption)}
							</select>
						</div>
						<div>
							<button type="submit" className="btn btn-primary" onClick={this.handleClick}>Submit</button>
						</div>
					</form>
				</div>

			</main>
		);
	}
}

export default AssigneeCreate;