function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/logout', true);
    xhr.send();
    window.location.replace('login');
}

function eventClic(e) {
			if (e) {
				e.preventDefault();
			}
			var nameSubF = document.getElementsByName('nameSubF')[0].value;
			var hoursF = document
					.getElementsByName('hoursF')[0].value;
			var avgMarkF = document
					.getElementsByName('avgMarkF')[0].value;
			var xhr = new XMLHttpRequest();
			var url = '/student-app/subject?'
					+ addParam('nameSubF', firstNameFiltr)
					+ addParam('hoursF', secondnameSortFiltr)
					+ addParam('avgMarkF', avgMark);
			xhr.open('GET', url, true);
			xhr.send();
			xhr.onload = function() {
				if (this.status === 200 || this.status === 206) {
					var data = JSON.parse(xhr.responseText);
					var table = document.getElementById('tbody');
					table.innerHTML = createTable(data);
				}
			}
		}

		function addSubject(e) {
			if (e) {
				e.preventDefault();
			}
			var name = document.getElementsByName('name')[0].value;
			var hours = document.getElementsByName('hours')[0].value;
			var avgMark = document.getElementsByName('avgMark')[0].value;
			var xhr = new XMLHttpRequest();
			var url = '/student-app/subject?'
					+ addParam('name', name)
					+ addParam('hours', hours)
					+ addParam('avgMark', avgMark);
			xhr.open('POST', url, true);
			xhr.send();
			xhr.onload = function() {
				if (this.status === 200 || this.status === 206) {
					eventClic(e);
				}
			}
		}
		
		function deleteMe(e, idForDelete) {
			if (e) {
				e.preventDefault();
			}

			var xhr = new XMLHttpRequest();
			var url = '/student-app/subject?'
					+ addParam('idForDelete', idForDelete);
			xhr.open('DELETE', url, true);
			xhr.send();
			xhr.onload = function() {
				if (this.status === 200 || this.status === 206) {
					eventClic(e);
				}
			}
		}

		function addParam(field, value) {
			return field + "=" + value + "&";
		}
		function createTable(data) {
			var rowData;
			var rowHTML;
			var tableHTML = "";
			for (var i = data.length - 1; i >= 0; i--) {
				rowData = data[i];
				rowHTML = "<tr>";
				rowHTML += "<td>" + rowData.name + "</td>";
				rowHTML += "<td>" + rowData.hours + "</td>";
				rowHTML += "<td>" + rowData.avgMark + "</td>";
				rowHTML += "<td><input type=\"button\"  class='my-button' onclick=\"deleteMe(event, "
						+ rowData.id + ")\" value=\"DELETE ME\"></td>"
				rowHTML += "</tr>";
				tableHTML += rowHTML;
			}
			tableHTML += "";
			return tableHTML;
		}
		eventClic();